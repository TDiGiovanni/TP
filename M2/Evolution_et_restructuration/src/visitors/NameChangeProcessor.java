package visitors;

import spoon.processing.AbstractProcessor;
import spoon.processing.Property;
import spoon.reflect.declaration.CtClass;

public class NameChangeProcessor extends AbstractProcessor<CtClass<?>>
{
    @Property
    String oldClassName;

    @Property
    String newClassName;

    @Override
    public void process(CtClass<?> element)
    {
        if (element.getSimpleName().equals(this.oldClassName))
            element.setSimpleName(this.newClassName);
    }
}