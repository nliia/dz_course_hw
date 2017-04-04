package ru.kpfu.itis.utils.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class ActualDateValidator implements ConstraintValidator<ActualDate, Object> {

    private String annotationDate;

    @Override
    public void initialize(ActualDate actualDate) {
        this.annotationDate = actualDate.date();
    }

    @Override
    public boolean isValid(Object date, ConstraintValidatorContext constraintValidatorContext) {
        try {
            final Object firstObj = BeanUtils.getProperty(date, annotationDate);
            Date newDate = (Date) firstObj;
            return newDate.after(new Date());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }
}
