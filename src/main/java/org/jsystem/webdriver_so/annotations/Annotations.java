package org.jsystem.webdriver_so.annotations;

import java.lang.reflect.Field;

import org.jsystem.webdriver_so.frames.ByFramePath;
import org.jsystem.webdriver_so.windows.ByWindowTitle;
import org.openqa.selenium.By;

/**
 * 
 * @author Aharon Hacmon
 * @since 1.07
 */
public class Annotations extends org.openqa.selenium.support.pagefactory.Annotations {

	private final Field field;
	public Annotations(Field field) {
		super(field);
		this.field = field;
	}

	@Override
	public By buildBy() {
		ElementInFrameList framelist;
		if ((framelist = field.getAnnotation(ElementInFrameList.class)) != null) {
			return new ByFramePath(super.buildBy(), framelist.value());
		} 
		ElementInWindow window;
		if ((window = field.getAnnotation(ElementInWindow.class)) != null){
			return new ByWindowTitle(super.buildBy(),window.windowTitle());
		}
		else {
			return super.buildBy();
		}
	}

}
