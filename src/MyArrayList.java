public class MyArrayList<T> implements MyList<T>
{
    private Object[] list;
    private int size;

    public MyArrayList()
    {
        this(5);
    }

    public MyArrayList(int capacity)
    {
        list = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++)
        {
            if(list[i] == o)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T item)
    {
        if(size >= list.length)
        {
            increaseCapacity();
        }
        list[size] = item;
        size++;
    }

    private void increaseCapacity()
    {
        Object[] newList = new Object[list.length * 2];
        for(int i = 0;i < newList.length;i++){
            newList[i] = list[i];
        }
        list = newList;
    }


    @Override
    public void add(T item, int index) {
        if(index >= size)
        {
            return;
        }
        list[index] = item;
    }

    @Override
    public boolean remove(T item) {
        for(int i = 0; i < size;i++){
            if(item == list[i])
            {
                remove(i);
                return  true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        Object data = list[index];
        for(int i = index; i < size-1;i++)
        {
            list[i] = list[i+1];
        }
        size--;
        return (T) data;
    }

    @Override
    public void clear() {
        list = new Object[5];
        size = 0;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return (T) list[index];
    }

    @Override
    public int indexOf(Object o){
    for(int i = 0; i < size; i++){
        if(o == list[i]){
            return i;
        }
    }
    return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--){
            if(o == list[i]){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        for(int i = 0; i < size-i;i++){
            for(int j = 0; j < size-1-i; j++){
                if ( (Integer) list[j] > (Integer) list[j+1])
                {
                    swapNext(j);
                }
            }
        }
    }

    private void swapNext(int i)
    {
        Object temp = list[i];
        list[i] = list[i + 1];
        list[i + 1] = temp;
    }
}
