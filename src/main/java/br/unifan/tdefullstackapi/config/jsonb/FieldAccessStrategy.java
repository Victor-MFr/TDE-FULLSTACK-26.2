/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifan.tdefullstackapi.config.jsonb;

/**
 *
 * @author USER
 */
import jakarta.json.bind.config.PropertyVisibilityStrategy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldAccessStrategy implements PropertyVisibilityStrategy {

    @Override
    public boolean isVisible(Field field) {
        return true;
    }

    @Override
    public boolean isVisible(Method method) {
        return false;
    }
}
