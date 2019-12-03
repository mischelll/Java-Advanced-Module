package javaoopexe.barracksWars.core.commands;

import javaoopexe.barracksWars.interfaces.Inject;
import javaoopexe.barracksWars.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;
    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
