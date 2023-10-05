// MedicineController.java
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private Map<Integer, Medicine> medicineMap = new HashMap<>();

    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        // Add logic to add medicine to the system
        if (!medicineMap.containsKey(medicine.getMedicineId())) {
            medicineMap.put(medicine.getMedicineId(), medicine);
            return true;
        }
        return false;
    }

    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        // Add logic to update medicine in the system
        if (medicineMap.containsKey(medicineId)) {
            Medicine existingMedicine = medicineMap.get(medicineId);
            // Update fields
            existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
            existingMedicine.setPrice(updatedMedicine.getPrice());
            existingMedicine.setQuantity(updatedMedicine.getQuantity());
            existingMedicine.setDescription(updatedMedicine.getDescription());
            return existingMedicine;
        }
        return null; // or handle as needed
    }
}
