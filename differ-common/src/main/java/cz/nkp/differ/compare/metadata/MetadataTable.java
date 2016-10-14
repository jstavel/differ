package cz.nkp.differ.compare.metadata;

/**
 * Proposose of Hash table class for metadata 
 * @author Zdeněk Janeček
 */
public class MetadataTable {
    
    /**
     * We don't need complicated Linked List
     */
    private class SimpleList {
        private ImageMetadata first;
        
        public void add(ImageMetadata m) {
            if (first == null) {
                first = m;
            } else {
//                ImageMetadata act = first;
//                while (act.next != null)
//                    act = act.next;
//                act.next = m;
            }
        }
    }
    
    private class MetadataContainer {
        private SimpleList list;
        private int count;
        
        public void addMetadata(ImageMetadata m) {
            if (list == null)
                list = new SimpleList();
            list.add(m);
        }
        
        public ImageMetadata[] getList() {
            ImageMetadata[] list = new ImageMetadata[count];
            
            return list;
        }
    }
    
    private int hashFunction(String s) {
     // TODO: Z - some hash that gives us index to table from string
        
        return 0;
    }
    
    private MetadataContainer[] table;
    
    /**
     * Get a list of extracted metadata with the given name in O(1).
     * @param name name of property
     * @return metadata with same name
     */
    public ImageMetadata[] getMetadata(String name) {
        // byte[] data = name.getBytes();
        
        int index = hashFunction(name);
        
        return table[index].getList();
    }
    
    /**
     * Insert metadata to the table.
     * @param m Object to insert.
     */
    public void giveMetadata(ImageMetadata m) {
        int index = hashFunction(m.getKey());
        
        table[index].addMetadata(m);
    }
}
