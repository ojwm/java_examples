class MyOuter {
   
   private int x;
   MyInner inner = new MyInner();
   
   class MyInner {
   
      void go() {
      
         x = 42;
      }
   }
   
   public void doStuff() {
   
      inner.go();
   }
}