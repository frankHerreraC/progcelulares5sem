public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0; // El saldo inicial es cero
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        } else {
            // Manejar la insuficiencia de fondos, puedes lanzar una excepción o manejarlo de otra manera
            System.out.println("Fondos insuficientes");
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }
}