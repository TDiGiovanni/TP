package concertStage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author Thomas
 */
public class Counter
{
    private PropertyChangeSupport propertySupport;
    private int count;
    private boolean started;
    
    public Counter()
    {
        super();
        this.propertySupport = new PropertyChangeSupport(this);
        this.count = 0;
        this.started = false;
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
    
    public boolean isStarted()
    {
        return this.started;
    }
    
    public void increment()
    {
        if (this.isStarted())
        {
            this.count++;
            propertySupport.firePropertyChange("count", count - 1, count);
        }
    }
    
    public void decrement()
    {
        if (this.isStarted())
        {
            this.count--;
            propertySupport.firePropertyChange("count", count + 1, count);
        }
    }
    
    public void clean()
    {
        if (this.isStarted())
        {
            int oldCount = count;
            this.count = 0;
            propertySupport.firePropertyChange("count", oldCount, count);
        }
    }
    
    public void start()
    {
        this.started = true;
    }
    
    public void stop()
    {
        this.started = false;
    }
}
