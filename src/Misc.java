public class Misc
{
  String[] sliceId(String id)
  {
    String[] slice = id.split("[-]+");

    return slice;
  }

  boolean checkId(String id)
  {
    String[] slice = sliceId(id);

    if(slice.length != 4)
      return false;
    else
    {
      if( (slice[0].length() == 4) && (slice[1].length() == 1) && (slice[2].length() == 2) && (slice[3].length() == 3) )
        return true;
      else
        return false;
    }
  }
}
