/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.biglobe.test.util.dbunit;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbUnitTesterProperty {

    @Getter
    @Value("${jdbc.dbName}")
    private String dbName;

}
