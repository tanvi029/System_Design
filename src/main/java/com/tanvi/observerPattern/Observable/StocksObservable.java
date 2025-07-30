package com.tanvi.observerPattern.Observable;

import com.tanvi.observerPattern.Observer.NotificationAlertObserver;

public interface StocksObservable {

    public  void add(NotificationAlertObserver observer);
    public void remove (NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int newStockAdded);
    public int getStockCount();
}
