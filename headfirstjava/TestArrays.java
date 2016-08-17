class TestArrays {

   public static void main (String[] args) {
//   
      String[] islands = new String[4];
//
      islands[0] = "Isle of Wight";
      islands[1] = "Isle of Man";
      islands[2] = "Jersey";
      islands[3] = "Isle of Sheppy";
//
      int[] index = new int[4];
//
      index[0] = 1;
      index[1] = 3;
      index[2] = 0;
      index[3] = 2;
//
      int y = 0;
//
      int ref;
      
      while (y < 4) {
//
         ref = index[y];
//
         System.out.print("island = ");
//
         System.out.println(islands[ref]);
//       
         y = y + 1;
//
      }
   }
}