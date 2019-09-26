package counter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author Thomas
 */
public class Counter
{
    private PropertyChangeSupport propertySupport;
    private int count;
    
    public Counter()
    {
        super();
        this.propertySupport = new PropertyChangeSupport(this);
        this.count = 0;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public int getCount()
    {
        return this.count;
    }

    public void increment()
    {
        this.count++;
    }
    
    public void decrement()
    {
        this.count--;
    }
}
