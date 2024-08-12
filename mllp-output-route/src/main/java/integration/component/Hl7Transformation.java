package integration.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import integration.messaging.component.processingstep.filter.MessageAcceptancePolicy;
import integration.messaging.component.processingstep.filter.MessageForwardingPolicy;
import integration.messaging.component.processingstep.transformation.BaseTransformationProcessingStep;
import integration.messaging.component.processingstep.transformation.MessageTransformer;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Hl7Transformation extends BaseTransformationProcessingStep {

    @Autowired
    @Qualifier("forwardAllMessages")
    private MessageForwardingPolicy messageForwardingPolicy;

    @Autowired
    @Qualifier("acceptAllMessages")
    private MessageAcceptancePolicy messageAcceptancePolicy;

    @Autowired
    @Qualifier("changeVersionTo2.5")
    private MessageTransformer messageTransformer;

    private static final String COMPONENT_NAME = "hl7-transformation";

    public Hl7Transformation() {
        super(COMPONENT_NAME);
    }

    private static final String CONTENT_TYPE = "HL7";

    @Override
    public MessageTransformer getTransformer() {
        return messageTransformer;
    }

    @Override
    public String getContentType() {
        return CONTENT_TYPE;
    }

    @Override
    public MessageAcceptancePolicy getMessageAcceptancePolicy() {
        return messageAcceptancePolicy;
    }

    @Override
    public MessageForwardingPolicy getMessageForwardingPolicy() {
        return messageForwardingPolicy;
    }
}
