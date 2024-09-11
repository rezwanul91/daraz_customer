package daraz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private  String name;
   private String address;
   private String email;
   private double rewardPoint;

   public Customer() {
   }

   public Customer(Integer id, String name, String address, String email, double rewardPoint) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.email = email;
      this.rewardPoint = rewardPoint;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public double getRewardPoint() {
      return rewardPoint;
   }

   public void setRewardPoint(double rewardPoint) {
      this.rewardPoint = rewardPoint;
   }
}
