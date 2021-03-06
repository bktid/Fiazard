package be.swsb.fiazard.ordering.orderplacement;

import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import be.swsb.fiazard.eventstore.EventStoreBundle;
import be.swsb.fiazard.main.FiazardConfig;


public class OrderPlacementBundle implements ConfiguredBundle<FiazardConfig> {

    private EventStoreBundle eventStoreBundle;

	public OrderPlacementBundle(EventStoreBundle eventStoreBundle) {
		this.eventStoreBundle = eventStoreBundle;
	}

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
    }

    @Override
    public void run(FiazardConfig configuration, Environment environment) throws Exception {
        environment.jersey().register(new OrderingResource(new OrderFactory(), eventStoreBundle.getAggregateRepository()));
    }

}
