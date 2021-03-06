package ch.rootkit.varoke.habbohotel.catalog.pages;

import ch.rootkit.varoke.communication.messages.ServerMessage;
import ch.rootkit.varoke.habbohotel.catalog.CatalogPage;

public class DucketsInfoPage extends Page{

	public DucketsInfoPage(CatalogPage p) {
		super(p);
	}
	@Override
	public void compose(ServerMessage message) throws Exception{
		message.writeString("NORMAL");
        message.writeString(getPage().getLayout());
        message.writeInt(1);
        message.writeString(getPage().getHeadline());
        message.writeInt(1);
        message.writeString(getPage().getText1());
	}
}
