package ObjectsAndClasses.Exercise.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private final int capacity;
    private final List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>(capacity);
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" The grooming salon has the following clients:");
        for (Pet pet : this.data) {
            stringBuilder.append(System.lineSeparator()).append(String.format("%s %s", pet.getName(), pet.getOwner()));
        }
        return stringBuilder.toString().trim();
    }
}
