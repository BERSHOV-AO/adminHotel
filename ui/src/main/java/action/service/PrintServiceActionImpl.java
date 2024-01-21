package action.service;

import action.api.IAction;
import controllers.service.ServiceManagerImpl;

public class PrintServiceActionImpl implements IAction {
    @Override
    public void execute() {
        System.out.println("-------All Services-------");
        ServiceManagerImpl.getInstance().getAllServices().stream().forEach(System.out::println);
    }
}
