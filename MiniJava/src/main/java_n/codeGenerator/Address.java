package codeGenerator;

/**
 * Created by mohammad hosein on 6/28/2015.
 */

public class Address {
    public int num;
    public TypeAddress Type;
    public varType varType;

    public Address(int num, varType varType, TypeAddress Type) {
        this.num = num;
        this.Type = Type;
        this.varType = varType;
    }

    public Address(int num, varType varType) {
        this.num = num;
        this.Type = TypeAddress.Direct;
        this.varType = varType;
    }

public String toString() {
    Map<TypeAddress, String> typeSymbols = new HashMap<>();
    typeSymbols.put(TypeAddress.Direct, "");
    typeSymbols.put(TypeAddress.Indirect, "@");
    typeSymbols.put(TypeAddress.Imidiate, "#");

    return typeSymbols.getOrDefault(Type, "") + num;
}
}
