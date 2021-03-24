
public class UseState implements State {
   private final boolean isFinal;
   private final int index;

   //constructor for a state, which includes an index and a boolean.
   public UseState(int index, boolean isFinal){
       this.index = index;
       this.isFinal = isFinal;

   }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean isFinal() {
        return isFinal;
    }
}
