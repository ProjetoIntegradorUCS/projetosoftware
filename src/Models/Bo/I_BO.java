package Models.Bo;

import Excecao.UsoExcecao;
import java.io.Serializable;

public interface I_BO extends Serializable
{
    public boolean cadastrar() throws UsoExcecao;
    public boolean validar() throws UsoExcecao;
}
