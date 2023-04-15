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

}
