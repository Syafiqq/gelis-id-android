package app.helmi.gelis.model.custom.java.util;

/*
 * This <Gelis> created by : 
 * Name         : syafiq
 * Date / Time  : 23 July 2017, 5:01 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

import java.util.List;
import java.util.Observable;

public class ObservableList<E> extends Observable
{
    private List<E> list;

    public ObservableList(List<E> list)
    {
        this.list = list;
    }

    public List<E> getList()
    {
        return this.list;
    }

    public void setList(List<E> list)
    {
        this.list = list;
    }

    public void update(List<E> body)
    {
        this.list.addAll(body);
        this.setChanged();
        this.notifyObservers();
    }
}
