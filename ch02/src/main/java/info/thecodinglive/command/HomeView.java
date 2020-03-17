package info.thecodinglive.command;

public class HomeView extends Command{

	@Override
	public void execute() {
		forward("/home.jsp");
	}
	
}
