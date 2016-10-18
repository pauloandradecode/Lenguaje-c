/****************************************************
Super clase

Name: Andrade Gonzalez Paulo Cesar
Fecha: 04/10/2016
****************************************************/

import java.util.Date;

public class CuentaBancaria
{
	public Date fechaAlta;
	public int nip;
	public String nombreCliente;
	public long numeroCuenta;
	public int numeroCliente;
	public double saldo;

	CuentaBancaria()
	{
		this.saldo = 0.0;
	}

	/*************************************************
	Metodos getter y setter
	*************************************************/

	public Date getFechaAlta()
	{
		return this.fechaAlta;
	}
	public int getNip()
	{
		return this.nip;
	}
	public String getNombreCliente()
	{
		return this.nombreCliente;
	}
	public long getNumeroCuenta()
	{
		return this.numeroCuenta;
	}
	public int getNumeroCliente()
	{
		return this.numeroCliente;
	}
	public double getSaldo()
	{
		return this.saldo;
	}
	public void setFechaAlta(Date fechaAlta)
	{
		this.fechaAlta = fechaAlta;
	}
	public void setNip(int nip)
	{
		this.nip = nip;
	}
	public void setNombreCliente(String nombreCliente)
	{
		this.nombreCliente = nombreCliente;
	}
	public void setNumeroCuenta(long numeroCuenta)
	{
		this.numeroCuenta = numeroCuenta;
	}
	public void setNumeroCliente(int numeroCliente)
	{
		this.numeroCliente = numeroCliente;
	}
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}

	/*************************************************
	Metodos
	*************************************************/

	public double consultar()
	{
		return this.saldo;
	}
	public void depositar(double deposito)
	{
		this.saldo += deposito;
	}
	public void retirar(double retiro)
	{
		this.saldo -= retiro;
	}
	/*
	public abstract double transferir();
	public abstract void cancelarCuenta();
	public abstract void contactoSoporte();
	*/
}