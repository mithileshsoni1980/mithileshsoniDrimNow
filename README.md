# execute below queries

INSERT INTO delivery_truck (id, max_weight, max_volume, current_weight, current_volume, postal_zone) VALUES ('TRUCK-001', 1000, 50, 0, 0, '123'), ('TRUCK-002', 900, 45, 0, 0, '123'), ('TRUCK-003', 800, 40, 0, 0, '124'), ('TRUCK-004', 1200, 55, 0, 0, '124'), ('TRUCK-005', 950, 42, 0, 0, '125'), ('TRUCK-006', 1100, 60, 0, 0, '125'), ('TRUCK-007', 700, 35, 0, 0, '126'), ('TRUCK-008', 1300, 70, 0, 0, '127'), ('TRUCK-009', 850, 38, 0, 0, '128'), ('TRUCK-010', 1050, 48, 0, 0, '129'), ('TRUCK-011', 1000, 50, 0, 0, '130'), ('TRUCK-012', 1000, 45, 0, 0, '130'), ('TRUCK-013', 950, 40, 0, 0, '131'), ('TRUCK-014', 900, 37, 0, 0, '132'), ('TRUCK-015', 1200, 60, 0, 0, '133'), ('TRUCK-016', 1150, 65, 0, 0, '134'), ('TRUCK-017', 950, 42, 0, 0, '135'), ('TRUCK-018', 800, 36, 0, 0, '136'), ('TRUCK-019', 750, 30, 0, 0, '137'), ('TRUCK-020', 1100, 55, 0, 0, '138')


# post man end point to create oreder   http://localhost:8081/orders  use below json

{
  "customerName": "Alice",
  "weight": 25.0,
  "volume": 1.0,
  "postalCode": "126",
  "priority": "STANDARD"
}
# post man end point to get truck details --http://localhost:8081/trucks
# post man end point to get assignement details --(http://localhost:8081/assignments);
# post man end point to get assigned truck details  by id--http://localhost:8081/assignments/truck/TRUCK-007
)

# http://localhost:8081/assignments
