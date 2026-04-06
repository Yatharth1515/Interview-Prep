package models;

import services.ExternalDispatcher;

public class ExternalButton {
    private ExternalDispatcher dispatcher;

    public ExternalButton(ExternalDispatcher externalDispatcher) {
        this.dispatcher = externalDispatcher;
    }

    void pressButton(Direction direction, int floor) {
        dispatcher.submitRequest(direction, floor);
    }
}
