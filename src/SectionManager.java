import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionManager {
  private HashMap<String, List<Section>> sections;

  public SectionManager() {
    sections = new HashMap<>();
  }

  public void addSection(String courseCode, Section section) {
    List<Section> courseSections = sections.get(courseCode);
    if (courseSections != null) {
      courseSections.add(section);
    } else {
      courseSections = new ArrayList<>();
      courseSections.add(section);
      sections.put(courseCode, courseSections);
    }
  }

  public void removeSection(String courseCode, int sectionNo) {
    List<Section> courseSections = sections.get(courseCode);
    if (courseSections != null) {
      Section sectionToRemove = null;
      for (Section section : courseSections) {
        if (section.getSectionNo() == sectionNo) {
          sectionToRemove = section;
          break;
        }
      }
      if (sectionToRemove != null) {
        courseSections.remove(sectionToRemove);
      }
    }
  }

  public void updateSection(String courseCode, int sectionNo) {
    List<Section> courseSections = sections.get(courseCode);
    if (courseSections != null) {
      for (Section section : courseSections) {
        if (section.getSectionNo() == sectionNo) {
          section.update();
          break;
        }
      }
    }
  }

  public List<Section> getCourseSections(String courseCode) {
    return sections.get(courseCode);
  }

  public List<Section> getAvailableSections(String courseCode) {
    List<Section> availableSections = new ArrayList<>();
    List<Section> courseSections = sections.get(courseCode);
    if (courseSections != null) {
      for (Section section : courseSections) {
        if (section.isAvailable()) {
          availableSections.add(section);
        }
      }
    }
    return availableSections;
  }

  public List<Section> getSections(String courseCode)
  {
    return sections.get(courseCode);
  }

  public void setSections(HashMap<String, List<Section>> sections)
  {
    this.sections = sections;
  }
}