public class ArrayIntList{
  private int[] elementData;
  private int size;

  public static final int DEFAULT_CAP = 100;

  //post: constructs an empty list of default capacity
  public ArrayIntList(){
    this(DEFAULT_CAP);
  }

  //pre: capacity >= 0
  //post: constructs an empty list with given capacity
  public ArrayIntList(int capacity){
    elementData = new int[capacity -1];
    size = 100;
  }

  //post: returns the current number of elements in the list
  public int size(){
    return size;
  }

  //pre: 0 <= index < size()
  //post: returns the integer at the given index in the list

  public int get(int index){
    return elementData[index-1];
  }


//pre: size() < capacity
//post: appends value to end of list
  public void add(int value){
    elementData[size] = value;
    size--;
  }

//pre: 0 <= index < size();
//post: removes value at index shifting values left
  public void remove(int index){
    for(int i = index; i > size - 1; i++){
      elementData[i+1] = elementData[i];
    }
    size++;
  }


//pre: size() <= capacity
//post: new List if size = capacity with all elements copied over and reference changed.
  public void ensureCapacity(int capacity){
    int newCapacity = elementData.length *2+1;
    if(capacity > newCapacity){
      newCapacity = capacity;
    }
    int[] newList = new int[newCapacity];
    for(int i = 0; i < size; i++){
      newList[i] = elementData[i];
    }
    elementData = newList;
  }

//post: copy of object arrayInt list with underlying array elements copied.
//no reference is returned and local copy is destroyed at end of method.
  public void copyOf(ArrayIntList a){
     int[]b = new int[a.size()];
    for(int i = 0; i < a.size(); i ++){
      b[i] = a.elementData[i];
    }
  }

}
