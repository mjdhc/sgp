/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.secjusticia.ejb;

import com.dh.secjusticia.modelo.SjSisRolMenUsuCen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cuevaw
 */
@Local
public interface SjSisRolMenUsuCenFacadeLocal {

    void create(SjSisRolMenUsuCen sjSisRolMenUsuCen);

    void edit(SjSisRolMenUsuCen sjSisRolMenUsuCen);

    void remove(SjSisRolMenUsuCen sjSisRolMenUsuCen);

    SjSisRolMenUsuCen find(Object id);

    List<SjSisRolMenUsuCen> findAll();

    List<SjSisRolMenUsuCen> findRange(int[] range);

    int count();
    
}
