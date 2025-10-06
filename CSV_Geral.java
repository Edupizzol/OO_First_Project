package Trabalho_OO;

public abstract class CSV_Geral {

    public abstract void SalvarCSV(Object obj);
    public abstract Object buscarCSV(String Nome);

    static boolean IsEqual = false;

    static boolean StrComp(String CPF, String Comp) {

        return IsEqual = CPF.equals(Comp);

    }

}
