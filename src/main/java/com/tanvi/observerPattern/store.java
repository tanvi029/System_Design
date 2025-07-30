package com.tanvi.observerPattern;

import com.tanvi.observerPattern.Observable.IphoneObserverImpl;
import com.tanvi.observerPattern.Observable.StocksObservable;
import com.tanvi.observerPattern.Observer.EmailAlertObserverImpl;
import com.tanvi.observerPattern.Observer.MobileAlertObserverImpl;
import com.tanvi.observerPattern.Observer.NotificationAlertObserver;

public class store {
    public static void main(String args[])
    {
        StocksObservable iphoneObservable = new IphoneObserverImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("abc", iphoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("userName", iphoneObservable);

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        iphoneObservable.setStockCount(10);
        iphoneObservable.setStockCount(-10);
       System.out.println( iphoneObservable.getStockCount());
       iphoneObservable.setStockCount(20);

    }
}
