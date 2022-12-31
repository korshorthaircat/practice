package _202212_.designPattern2;

import java.util.ArrayList;
import java.util.List;

interface Subject { //주체 - 객체의 상태변화를 보고 있는 관찰자
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    public Object getUpdate(Observer obj);
}

interface Observer {
    public void update();

}

class Topic implements Subject {
    private List<Observer> observers;
    private String message;

    public void postMessage(String msg) {
        System.out.println("Message sended to Topic: " + msg);
        this.message = msg;
        notifyObservers();
    }

    @Override
    public void register(Observer obj) {
        if(!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public Topic() {
        this.observers = new ArrayList<>();
        this.message = "";
    }
}

class TopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        System.out.println(name + ":: got Message >> " + msg);
    }

    public TopicSubscriber(String name, Subject topic) {
        this.name = name;
        this.topic = topic;
    }
}

public class ObserverPatternTest {
    public static void main (String[] args) {

        Topic topic = new Topic();

        Observer observerA = new TopicSubscriber("a", topic);
        Observer observerB = new TopicSubscriber("b", topic);
        Observer observerC = new TopicSubscriber("c", topic);

        topic.register(observerA);
        topic.register(observerB);
        topic.register(observerC);

        topic.postMessage("Happy New Year!");
    }
}
