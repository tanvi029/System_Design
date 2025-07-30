package com.tanvi.observerPattern.Observer;

import com.tanvi.observerPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    StocksObservable stocksObservable;

    public EmailAlertObserverImpl(String emailId, StocksObservable observable)
    {
        this.emailId=emailId;
        this.stocksObservable=observable;
    }
    @Override
    public void update() {
        sendEmail(emailId, "product is in stock hurry up!");

    }

    private void sendEmail(String emailId, String s) {
        System.out.println("mail sent to: "+emailId);
    }
}
