package by.myFin.annotation;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class BeanNameDoesNotExistCondition implements Condition
{
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
	{
		Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(
				"my.myFin.annotation.QAComponent");

		String componentName = null;
		if (annotationAttributes != null)
		{
			componentName = (String) annotationAttributes.get("value");
		}
		return !StringUtils.isNotBlank(componentName) || !context.getRegistry().containsBeanDefinition(componentName);
	}
}
