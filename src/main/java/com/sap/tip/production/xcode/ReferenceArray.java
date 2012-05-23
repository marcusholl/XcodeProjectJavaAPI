package com.sap.tip.production.xcode;

import java.util.Iterator;

public class ReferenceArray<T extends Element> implements Iterable<T>
{
  private final ProjectFile projectFile;
  private final Array refs;
  private final ElementFactory<T> elementFactory;

  public ReferenceArray(ProjectFile projectFile, Array refs, ElementFactory<T> elementFactory)
  {
    this.projectFile = projectFile;
    this.refs = refs;
    this.elementFactory = elementFactory;
  }

  @Override
  public Iterator<T> iterator()
  {
    return new Iterator<T>() {

      private Iterator<Object> refsIterator = refs.iterator();

      @Override
      public boolean hasNext()
      {
        return refsIterator.hasNext();
      }

      @Override
      public T next()
      {
        return createObjectFromRef((String) refsIterator.next());
      }

      @Override
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }

  private T createObjectFromRef(String ref)
  {
    return elementFactory.create(projectFile, projectFile.getObjectByReference(ref));
  }

  public T get(int index)
  {
    String ref = (String) refs.get(index);
    return createObjectFromRef(ref);
  }

  public T getByName(String name)
  {
    for (T object : this)
    {
      if (name.equals(object.getString("name")))
      {
        return object;
      }
    }
    return null;
  }

  public int size()
  {
    return refs.size();
  }

  public void add(T object)
  {
    String ref = projectFile.generateReference();
    projectFile.setObjectByReference(ref, object.getDict());
    refs.add(ref);
  }
}
