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

}
