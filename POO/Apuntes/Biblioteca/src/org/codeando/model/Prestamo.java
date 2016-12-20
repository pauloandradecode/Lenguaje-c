package org.codeando.model;

import java.util.Date;

/**
 * Created by root on 2/12/16.
 * Interface para implementar metodo de recargos
 */

public interface Prestamo
{
    Date recargos(Date in, Date out);
}
