public class FlattenArray {

	//Merge two arrays of integers into one
    private static Integer[] mergeArrays(Integer[] a1, Integer[] a2){
    	int s = a1.length + a2.length;
    	Integer[] a = new Integer[s];
    	for (int i = 0; i < a1.length; i++)
    		a[i] = a1[i];
    	for (int i = a1.length; i < s; i++)
    		a[i] = a2[i - a1.length];
    	return a;
    }
    
    //This recursive method does the main work: array flattening 
    public static Integer[] flatten(Object unflattened){
        Integer f[];
        if (unflattened instanceof Object[]){
    		int l = ((Object[]) unflattened).length;
    		f = new Integer[0];
    		Object[] u = (Object[]) unflattened;
    			for (int i = 0; i < l; i++){
    				//recursion
    				f = mergeArrays(f, flatten(u[i]));
    			}
        }
        else{
        	f = new Integer[1];
        	f[0] = (Integer) unflattened;
        }
        return f;
    }
        	
	public static void main(String[] args) {
		//sample unflattened array
		Integer[][][] u = {{{4}, {7}, {9}}, {{5, 6, 11}, {35}, {55}, {17}}, {{8}, {-5}, {12, 16, 23}}};
		Integer f[] = FlattenArray.flatten(u);
		//printing a flattened one
		for (int i = 0; i < f.length; i++)
			System.out.print(" " + f[i]);
	}

}
