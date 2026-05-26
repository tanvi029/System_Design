package com.tanvi.observerPattern.Observer;

import com.tanvi.observerPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String userName;
    StocksObservable observable;

    public MobileAlertObserverImpl(String userName, StocksObservable observable)
    {
        this.observable=observable;
        this.userName=userName;
    }

    @Override
    public void update() {
        sendMsgMobile(userName, "product is in stock");

    }

    private void sendMsgMobile(String userName, String productIsInStock) {
        System.out.println("msg sent to "+userName);
    }
}
