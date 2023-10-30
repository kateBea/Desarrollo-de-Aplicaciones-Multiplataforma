package dam2.org.xmldomysax;

import java.util.HashSet;
import java.util.Set;

public class Cuenta {
	private String ncc;
	private float saldo;
	private Set<Cliente> clientes;
	
	
	public Cuenta ()
	{
		this ("");
	}
	
	public Cuenta(String ncc) {
		
		this.ncc = ncc;
		this.saldo = 0;
		this.clientes = new HashSet<Cliente>();
	}
	
	
	public Cuenta(String ncc, float saldo, Set<Cliente> clientes) {
	
		this.ncc = ncc;
		this.saldo = saldo;
		this.clientes = clientes;
	}

	public String getNcc() {
		return ncc;
	}

	public void setNcc(String ncc) {
		this.ncc = ncc;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	public boolean addCliente (Cliente cliente)
	{
		return clientes.add(cliente);
	}

	@Override
	public String toString() {
		return "Cuenta [ncc=" + ncc + ", saldo=" + saldo + ", clientes=" + clientes + "]";
	}
	
	

}
