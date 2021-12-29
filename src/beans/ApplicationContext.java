package beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import dao.TypeOfBuyerDAO;
import dao.UserDAO;
import dao.ArticalDAO;
import dao.CartDAO;
import dao.CartItemDAO;
import dao.LocationDAO;
import dao.OrderItemDAO;
import dao.RestaurantDAO;


public class ApplicationContext {
	
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Artical> articals = new ArrayList<Artical>();
	private ArrayList<Cart> carts = new ArrayList<Cart>();
	private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private ArrayList<Location> locations = new ArrayList<Location>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
	private ArrayList<TypeOfBuyer> typeOfBuyers = new ArrayList<TypeOfBuyer>();
	private String contextPath = "";
	
	public ApplicationContext() {
	}
	
	public String getContextPath()
	{
		return contextPath;
	}
	
	public void setContextPath(String contextPath)
	{
		if(this.contextPath.equals("")) {
			this.contextPath = contextPath;
			Load();
		}
	}
	
	private static ApplicationContext instance = null;
	
	public static ApplicationContext getInstane() {
		
		if(instance == null) {
			instance = new ApplicationContext();
			
		}
		
		return instance;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Artical> getArticals() {
		return articals;
	}

	public void setArticals(ArrayList<Artical> articals) {
		this.articals = articals;
	}

	public ArrayList<Cart> getCarts() {
		return carts;
	}

	public void setCarts(ArrayList<Cart> carts) {
		this.carts = carts;
	}

	public ArrayList<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(ArrayList<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(ArrayList<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public ArrayList<TypeOfBuyer> getTypeOfBuyers() {
		return typeOfBuyers;
	}

	public void setTypeOfBuyers(ArrayList<TypeOfBuyer> typeOfBuyers) {
		this.typeOfBuyers = typeOfBuyers;
	}
	
	public void Load() 
	{
		loadUsers(contextPath);
		loadArticals(contextPath);
		loadCart(contextPath);
		loadCartItem(contextPath);
		loadComment(contextPath);
		loadLocation(contextPath);
		loadOrder(contextPath);
		loadOrderItem(contextPath);
		loadRestaurant(contextPath);
		loadTypeOfBuyer(contextPath);
		
		
	}
	
	public void Save()
	{
		saveUsers(contextPath);
		saveArticals(contextPath);
		saveCart(contextPath);
		saveCartItem(contextPath);
		saveComment(contextPath);
		saveLocation(contextPath);
		saveOrder(contextPath);
		saveOrderItem(contextPath);
		saveRestaurant(contextPath);
		saveTypeOfBuyer(contextPath);
	}
	
	
		public void saveArticals(String contextPath)
		{
			File file = new File(contextPath + "/articals.txt");
			
			try 
			{
				BufferedWriter out = new  BufferedWriter(new FileWriter(file));
				String result = "";
				
			for(Artical artical : articals)
			{
				result += artical.exportToString() + "\n";
			}
			
			out.write(result);
			out.close();
		
			}
			
		catch(Exception e)
			{
			
			}
		}
		
		
		
		public void loadArticals(String contextPath) 
		{
		
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/articals.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					String iD = st.nextToken().trim();
					String articalName = st.nextToken().trim();
					Double price =Double.parseDouble(st.nextToken().trim()) ;
					String articalTypeString = st.nextToken().trim();
					ArticalType articalType;
					
					if(articalTypeString.equals("Drink")) 
					{
						articalType = ArticalType.Drink;
					}
					else 
					{
						articalType = ArticalType.Food;
					}
					

					String quantity = st.nextToken().trim();

					String description = st.nextToken().trim();
					
					String picture = st.nextToken().trim();
					
					String idRestaurant = st.nextToken().trim();
					RestaurantDAO restaurantdao = new RestaurantDAO();
					Restaurant restaurant = restaurantdao.findById(idRestaurant);
					
					articals.add(new Artical(iD, articalName, price, articalType, quantity, description , picture, restaurant));
					}
					
					}
				}catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (in != null) {
						try {
							in.close();
						}
						catch (Exception e) { }
					}
				}
			}

				public void saveCart(String contextPath)
				{
					File file = new File(contextPath + "/carts.txt");
					
					try 
					{
						BufferedWriter out = new  BufferedWriter(new FileWriter(file));
						String result = "";
						
					for(Cart cart : carts)
					{
						result += cart.exportToString() + "\n";
					}
					
					out.write(result);
					out.close();
				
					}
					
				catch(Exception e)
					{
					
					}
				}
			
				public void loadCart(String contextPath) {
					
					
					BufferedReader in = null;
					try {
						File file = new File(contextPath + "/carts.txt");
						in = new BufferedReader(new FileReader(file));
						String line;
						StringTokenizer st;
						while ((line = in.readLine()) != null) {
							line = line.trim();
							if (line.equals("") || line.indexOf('#') == 0)
								continue;
							st = new StringTokenizer(line, ";");
							while (st.hasMoreTokens()) {
								String iD = st.nextToken().trim();
								Double binPrice =Double.parseDouble(st.nextToken().trim()) ;
								
								String idBuyer = st.nextToken().trim();
								UserDAO buyerdao = new UserDAO();
								User buyer = buyerdao.findById(idBuyer);
			
								String idCartItem = st.nextToken().trim();
								CartItemDAO cartItemdao = new CartItemDAO();
								CartItem cartItem = cartItemdao.findById(idCartItem);
								
								carts.add(new Cart(iD, binPrice, buyer, cartItem));
							}
							
						}
					}catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (in != null) {
							try {
								in.close();
							}
							catch (Exception e) { }
						}
					}
				}
	
			
			public void saveCartItem(String contextPath)
			{
				File file = new File(contextPath + "/cartItems.txt");
				
				try 
				{
					BufferedWriter out = new  BufferedWriter(new FileWriter(file));
					String result = "";
					
				for(CartItem cartItem : cartItems)
				{
					result += cartItem.exportToString() + "\n";
				}
				
				out.write(result);
				out.close();
			
				}
				
			catch(Exception e)
				{
				
				}
			}
			
	
			public void loadCartItem(String contextPath) {
					
				
				BufferedReader in = null;
				try {
					File file = new File(contextPath + "/cartItems.txt");
					in = new BufferedReader(new FileReader(file));
					String line;
					StringTokenizer st;
					while ((line = in.readLine()) != null) {
						line = line.trim();
						if (line.equals("") || line.indexOf('#') == 0)
							continue;
						st = new StringTokenizer(line, ";");
						while (st.hasMoreTokens()) {
							String iD = st.nextToken().trim();
							
							String idBin = st.nextToken().trim();
							CartDAO bindao = new CartDAO();
							Cart bin = bindao.findById(idBin);
							
							String idArtical = st.nextToken().trim();
							ArticalDAO articaldao = new ArticalDAO();
							Artical artical = articaldao.findById(idArtical);
							
							String quantity = st.nextToken().trim();
							
							cartItems.add(new CartItem(iD, bin, artical, quantity));
						}
						
					}
				}catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					if (in != null) {
						try {
							in.close();
						}
						catch (Exception e) { }
					}
				}
			}
		

		public void saveComment(String contextPath)
		{
			File file = new File(contextPath + "/comments.txt");
			
			try 
			{
				BufferedWriter out = new  BufferedWriter(new FileWriter(file));
				String result = "";
				
			for(Comment comment : comments)
			{
				result += comment.exportToString() + "\n";
			}
			
			out.write(result);
			out.close();
		
			}
			
		catch(Exception e)
			{
			
			}
		}
		
		
		
		public void loadComment(String contextPath) {
			
			
			BufferedReader in = null;
			try {
				File file = new File(contextPath + "/comments.txt");
				in = new BufferedReader(new FileReader(file));
				String line;
				StringTokenizer st;
				while ((line = in.readLine()) != null) {
					line = line.trim();
					if (line.equals("") || line.indexOf('#') == 0)
						continue;
					st = new StringTokenizer(line, ";");
					while (st.hasMoreTokens()) {
						
						String iD = st.nextToken().trim();
						
						String idUser = st.nextToken().trim();
						UserDAO userdao = new UserDAO();
						User user = userdao.findById(idUser);
						
						String idRestaurant = st.nextToken().trim();
						RestaurantDAO restaurantdao = new RestaurantDAO();
						Restaurant restaurant = restaurantdao.findById(idRestaurant);
						
						String gradeString = st.nextToken().trim();
						Grade grade;
						
						if(gradeString.equals("One")) {
							grade = Grade.one;
						}
						
						else if (gradeString.equals("Two"))
						{
							grade=Grade.two;
						}
						else if (gradeString.equals("Three"))
						{
							grade = Grade.three;
						}
						else if (gradeString.equals("Four"))
						{
							grade = Grade.four;
						}
						else 
						{
							grade = Grade.five;
						}
						
						String commentText = st.nextToken().trim();
						
						comments.add(new Comment(iD , user , restaurant ,  commentText, grade));
					}
					
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					}
					catch (Exception e) { }
				}
			}
		}
		
		public void saveLocation(String contextPath)
		{
			File file = new File(contextPath + "/locations.txt");
			
			try 
			{
				BufferedWriter out = new  BufferedWriter(new FileWriter(file));
				String result = "";
				
			for(Location location : locations)
			{
				result += location.exportToString() + "\n";
			}
			
			out.write(result);
			out.close();
		
			}
			
		catch(Exception e)
			{
			
			}
		}
		
		
		
		public void loadLocation(String contextPath) {
			
			
			BufferedReader in = null;
			try {
				File file = new File(contextPath + "/locations.txt");
				in = new BufferedReader(new FileReader(file));
				String line;
				StringTokenizer st;
				while ((line = in.readLine()) != null) {
					line = line.trim();
					if (line.equals("") || line.indexOf('#') == 0)
						continue;
					st = new StringTokenizer(line, ";");
					while (st.hasMoreTokens()) {
						String iD = st.nextToken().trim();
						Double geograficalLenght =Double.parseDouble(st.nextToken().trim());
						Double geograficalWidth =Double.parseDouble(st.nextToken().trim());
						String adress = st.nextToken().trim();
						String city = st.nextToken().trim();
						String country = st.nextToken().trim();
						
						locations.add(new Location(iD, geograficalLenght, geograficalWidth, adress, city, country));
					}
					
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					}
					catch (Exception e) { }
				}
			}
		}
		
		public void saveOrder(String contextPath)
		{
			File file = new File(contextPath + "/orders.txt");
			
			try 
			{
				BufferedWriter out = new  BufferedWriter(new FileWriter(file));
				String result = "";
				
			for(Order order : orders)
			{
				result += 	order.exportToString() + "\n";
			}
			
			out.write(result);
			out.close();
		
			}
			
		catch(Exception e)
			{
			
			}
		}
		
		public void loadOrder(String contextPath) {
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			BufferedReader in = null;
			try {
				File file = new File(contextPath + "/orders.txt");
				in = new BufferedReader(new FileReader(file));
				String line;
				StringTokenizer st;
				while ((line = in.readLine()) != null) {
					line = line.trim();
					if (line.equals("") || line.indexOf('#') == 0)
						continue;
					st = new StringTokenizer(line, ";");
					while (st.hasMoreTokens()) {
						String idOrder = st.nextToken().trim();
						Date orderDate = simpleDateFormat.parse(st.nextToken().trim());
						double priceOrder =Double.parseDouble(st.nextToken().trim());
						String orderStatusString = st.nextToken().trim();
						OrderStatus orderStatus;
						
						if(orderStatusString.equals("Processing")) {
							orderStatus = OrderStatus.Processing;
						}
						
						else if (orderStatusString.equals("InPreparation"))
						{
							orderStatus=OrderStatus.InPreparation;
						}
						else if (orderStatusString.equals("WaitingForSupplies"))
						{
							orderStatus = OrderStatus.WaitingForSupplies;
						}
						else if (orderStatusString.equals("Transport"))
						{
							orderStatus = OrderStatus.Transport;
						}
						else if (orderStatusString.equals("Delivered"))
						{
							orderStatus = OrderStatus.Delivered;
						}
						else 
						{
							orderStatus = OrderStatus.Canceled;
						}

						String idBuyer = st.nextToken().trim();
						UserDAO buyerdao = new UserDAO();
						User buyer = buyerdao.findById(idBuyer);

						String idDeliveryGuy = st.nextToken().trim();
						UserDAO deliveryGuydao = new UserDAO();
						User deliveryGuy = deliveryGuydao.findById(idDeliveryGuy);

						String idCart = st.nextToken().trim();
						CartDAO cartdao = new CartDAO();
						Cart cart = cartdao.findById(idCart);

						String idOrderItem = st.nextToken().trim();
						OrderItemDAO orderItemdao = new OrderItemDAO();
						OrderItem orderItem = orderItemdao.findById(idOrderItem);
						
						
						
						orders.add(new Order(idOrder , orderDate , priceOrder, orderStatus, buyer, deliveryGuy, cart , orderItem));
					}
					
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					}
					catch (Exception e) { }
				}
			}
		}
		
		public void saveOrderItem(String contextPath)
		{
			File file = new File(contextPath + "/orderItems.txt");
			
			try 
			{
				BufferedWriter out = new  BufferedWriter(new FileWriter(file));
				String result = "";
				
			for(OrderItem orderItem : orderItems)
			{
				result += 	orderItem.exportToString() + "\n";
			}
			
			out.write(result);
			out.close();
		
			}
			
		catch(Exception e)
			{
			
			}
		}
	
		public void loadOrderItem(String contextPath) {
			
			BufferedReader in = null;
			try {
				File file = new File(contextPath + "/orderItems.txt");
				in = new BufferedReader(new FileReader(file));
				String line;
				StringTokenizer st;
				while ((line = in.readLine()) != null) {
					line = line.trim();
					if (line.equals("") || line.indexOf('#') == 0)
						continue;
					st = new StringTokenizer(line, ";");
					while (st.hasMoreTokens()) {
						String id = st.nextToken().trim();
						String idArtical = st.nextToken().trim();
						ArticalDAO articaldao = new ArticalDAO();
						Artical artical = articaldao.findById(idArtical);
						String idRestaurant = st.nextToken().trim();
						RestaurantDAO restaurantdao = new RestaurantDAO();
						Restaurant restaurant = restaurantdao.findById(idRestaurant);
						
						orderItems.add(new OrderItem (id, artical, restaurant));
					}
					
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					}
					catch (Exception e) { }
				}
			}
		}
		
		public void saveRestaurant(String contextPath)
		{
			File file = new File(contextPath + "/restaurants.txt");
			
			try 
			{
				BufferedWriter out = new  BufferedWriter(new FileWriter(file));
				String result = "";
				
			for(Restaurant restaurant : restaurants)
			{
				result += 	restaurant.exportToString() + "\n";
			}
			
			out.write(result);
			out.close();
		
			}
			
		catch(Exception e)
			{
			
			}
		}
	
		
		
		public void loadRestaurant(String contextPath) {
			
			
			BufferedReader in = null;
			try {
				File file = new File(contextPath + "/restaurants.txt");
				in = new BufferedReader(new FileReader(file));
				String line;
				StringTokenizer st;
				while ((line = in.readLine()) != null) {
					line = line.trim();
					if (line.equals("") || line.indexOf('#') == 0)
						continue;
					st = new StringTokenizer(line, ";");
					while (st.hasMoreTokens()) {
						String id = st.nextToken().trim();
						String restaurantName = st.nextToken().trim();
						String restaurantType = st.nextToken().trim();
						
						String statusString = st.nextToken().trim();
						Status status;
						if(statusString.equals("Open")) {
							status = Status.Open;
						}
						else 
						{
							status = Status.Close;
						}
						
						String logoOfRestaurant = st.nextToken().trim();

						String idUser = st.nextToken().trim();
						UserDAO userdao = new UserDAO();
						User user = userdao.findById(idUser);
						
						String idLocation = st.nextToken().trim();
						LocationDAO locationdao = new LocationDAO();
						Location location = locationdao.findById(idLocation);
						
						
						restaurants.add(new Restaurant(id , restaurantName , restaurantType, status, logoOfRestaurant, location , user ));
					}
					
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					}
					catch (Exception e) { }
				}
			}
		}
		

		public void saveTypeOfBuyer(String contextPath)
		{
			File file = new File(contextPath + "/typeOfBuyers.txt");
			
			try 
			{
				BufferedWriter out = new  BufferedWriter(new FileWriter(file));
				String result = "";
				
			for(TypeOfBuyer typeOfBuyer : typeOfBuyers)
			{
				result += typeOfBuyer.exportToString() + "\n";
			}
			
			out.write(result);
			out.close();
		
			}
			
		catch(Exception e)
			{
			
			}
		}
	
		public void loadTypeOfBuyer(String contextPath) {
			
			
			BufferedReader in = null;
			try {
				File file = new File(contextPath + "/TypesOfBuyer.txt");
				in = new BufferedReader(new FileReader(file));
				String line;
				StringTokenizer st;
				while ((line = in.readLine()) != null) {
					line = line.trim();
					if (line.equals("") || line.indexOf('#') == 0)
						continue;
					st = new StringTokenizer(line, ";");
					while (st.hasMoreTokens()) {
						String iD = st.nextToken().trim();
						
						String nameOfTypeString = st.nextToken().trim();
						NameOfType nameOfType;
						
						if(nameOfTypeString.equals("Gold")) {
							
							nameOfType = NameOfType.Gold;
						}
						else if (nameOfTypeString.equals("Bronze"))
						{
							nameOfType = NameOfType.Bronze;
						}
						else 
						{
							nameOfType = NameOfType.Silver;
						}
						
						Double discount = Double.parseDouble(st.nextToken().trim());
						String requestedPoints = st.nextToken().trim();
						
						
						typeOfBuyers.add(new TypeOfBuyer(iD , nameOfType , discount, requestedPoints));
					}
					
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					}
					catch (Exception e) { }
				}
			}
		}
		
		public void saveUsers(String contextPath)
		{
			File file = new File(contextPath + "/users.txt");
			
			try 
			{
				BufferedWriter out = new  BufferedWriter(new FileWriter(file));
				String result = "";
				
			for(User user : users)
			{
				result += user.exportToString() + "\n";
			}
			
			out.write(result);
			out.close();
		
			}
			
		catch(Exception e)
			{
			
			}
		}
	
		
		
		public void loadUsers(String contextPath) {
			
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			
			BufferedReader in = null;
			try {
				File file = new File(contextPath + "/Users.txt");
				in = new BufferedReader(new FileReader(file));
				String line;
				StringTokenizer st;
				while ((line = in.readLine()) != null) {
					line = line.trim();
					if (line.equals("") || line.indexOf('#') == 0)
						continue;
					st = new StringTokenizer(line, ";");
					while (st.hasMoreTokens()) {
						String iD = st.nextToken().trim();
						String username = st.nextToken().trim();
						String password = st.nextToken().trim();
						String name = st.nextToken().trim();
						String surname = st.nextToken().trim();
						
						String genderString = st.nextToken().trim();
						Gender gender;
						
						if(genderString.equals("Male")) {
							gender = Gender.Male;
						}
						else if(genderString.equals("Female"))
						{
							gender = Gender.Female;
						}
						else
						{
							gender = Gender.Other;
						}
						
						Date birthDate = simpleDateFormat.parse(st.nextToken().trim());
						
						String roleString = st.nextToken().trim();
						Role role;
						
						if(roleString.equals("administator")) {
							role = Role.administator;
						}
						else if(roleString.equals("menager"))
						{
							role = Role.menager;
						}
						else if(roleString.equals("deliverGuy"))
						{
							role = Role.deliverGuy;
						}
						else
						{
							role = Role.buyer;
						}
						
						String nummberOfPoints = st.nextToken().trim();
						String idTypeOfBuyer = st.nextToken().trim();
						TypeOfBuyerDAO typeOfBuyerdao = new TypeOfBuyerDAO();
						TypeOfBuyer typeOfBuyer = typeOfBuyerdao.findById(idTypeOfBuyer);
						
						users.add(new User(iD , username , password, name, surname, gender, birthDate, role, nummberOfPoints, typeOfBuyer));
					}
					
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					}
					catch (Exception e) { }
				}
			}
		}
		
		
}
