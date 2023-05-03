/*
 * Créer une collection qui n'accepte que :
 * - Des Automobiles de marqeu Ferrari 
 * - 3 au maximum
 * - Que de couleur rouge
 * 
 * En plus, on va prévoir une méthode capable de retourner le prix total de la collection.
 * Cette classe doit hériter de  Collection
 * 
 * 
 */

package fr.collections;

import java.util.*;

public class MesFerraris implements Collection<Automobile>
{
	private Vector<Automobile> contenu = new Vector<>();
	
	@Override
	public boolean add(Automobile a)
	{
		if(!a.getMarque().equalsIgnoreCase("Ferrari")) // Pour éviter d'avoir à gérer les majuscules et les minuscules
		{
			return false;
		}
		
		if(!a.getCouleur().equalsIgnoreCase("Rouge"))
		{
			return false;
		}
		
		if(size() >= 3) // Ne pas autoriser le dépot de plus de trois Ferraris Rouges
		{
			return false;
		}
		
		return contenu.add(a);
	}

	@Override
	public int size()
	{
		return contenu.size();
	}

	@Override
	public boolean isEmpty()
	{
		return (contenu.size() == 0);
	}

	@Override
	public boolean contains(Object o)
	{
		return contenu.contains(o);
	}

	@Override
	public Object[] toArray()
	{
		return contenu.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		return contenu.toArray(a);
	}


	@Override
	public boolean remove(Object o)
	{
		return contenu.remove(o);
	}

	@Override
	public Iterator<Automobile> iterator()
	{
		return contenu.iterator();
	}
	
	@Override
	public boolean containsAll(Collection<?> c)
	{
		return contenu.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Automobile> c)
	{
		return contenu.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return contenu.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return contenu.retainAll(c);
	}

	@Override
	public void clear() {
		contenu.clear();
	}
	
	// Méthode personnalisée pour obtenir le prix de la collection
	public float getPrixTotal()
	{
		// On va boucler
		float prixTotal = 0;
		
		for(Automobile a : contenu)
		{
			prixTotal += a.getPrix();
		}
		
		return prixTotal;
	}
}
