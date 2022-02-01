package beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

import dao.ArticalDAO;
import dao.CartDAO;
import dao.CartItemDAO;
import dao.LocationDAO;
import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.RestourantDAO;
import dao.TypeOfCostumerDAO;
import dao.UserDAO;

import java.util.Date;

public class WebContext {
	
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Artical> articals = new ArrayList<Artical>();
	private ArrayList<Cart> carts = new ArrayList<Cart>();
	private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private ArrayList<Location> locations = new ArrayList<Location>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
	private ArrayList<TypeOfCostumer> typeOfCostumers = new ArrayList<TypeOfCostumer>();
	private String contextPath;
	private static WebContext instance = null;
	
	public static WebContext getInstance()
	{
		if(instance == null) 
		{
			instance = new WebContext();
			
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

	public ArrayList<TypeOfCostumer> getTypeOfCostumers() {
		return typeOfCostumers;
	}

	public void setTypeOfCostumers(ArrayList<TypeOfCostumer> typeOfCostumers) {
		this.typeOfCostumers = typeOfCostumers;
	}
	
	public String getContextPath()
	{
		return contextPath;
	}
	
	public void setContextPath(String contextPath)
	{
		if(this.contextPath == null) {
			load(contextPath);
		}
		
		this.contextPath = contextPath;
	}
	
	public void load(String contextPath) 
	{
		loadUsers(contextPath);		
		loadLocations(contextPath);
		loadRestaurants(contextPath);
		loadArticals(contextPath);
		loadCarts(contextPath);
		loadCartItem(contextPath);
		loadComments(contextPath);
		loadOrderItems(contextPath);
		loadOrders(contextPath);
		loadTypeOfCostumers(contextPath);
	}
	
	public void loadUsers(String contextPath) {
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
	//	String date =
		
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/users.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String userID = st.nextToken().trim();
					String username = st.nextToken().trim();
					String password = st.nextToken().trim();
					String firstName = st.nextToken().trim();
					String lastName = st.nextToken().trim();
					String genderString = st.nextToken().trim();
					Gender gender;
					if(genderString.equals("Male")) 
					{
						gender = Gender.Male;
					} else if(genderString.equals("Female"))
					{
						gender = Gender.Female;
					} else 
					{
						gender = Gender.Other;
					}
				
				
					Date dateOfBirth = simpleDateFormat.parse(st.nextToken().trim());
				    String roleString = st.nextToken().trim();
				    Role role;
				    if(roleString.equals("Administrator"))
				    { 
				    	role = Role.Administrator;
				    } else if(roleString.equals("Manager"))
				    {
				    	role = Role.Manager;
				    } else if(roleString.equals("DeliveryGuy"))
				    {
				    	role = Role.DeliveryGuy;
				    } else
				    {
				    	role = Role.Buyer;
				    }
				    
					String pointsCollected = st.nextToken().trim();
					
					String TypeOfBuyer = st.nextToken().trim();
					TypeOfCostumerDAO typeOfCostumerDAO = new TypeOfCostumerDAO();
					TypeOfCostumer typeOfCostumer = new TypeOfCostumer();
					if(TypeOfBuyer.equals("Bronze"))
					{
						typeOfCostumer.setNameType(NameType.Bronze);
						typeOfCostumerDAO.setDiscount(typeOfCostumer);
						typeOfCostumerDAO.setRequestedPoints(typeOfCostumer);
					}
					else if(TypeOfBuyer.equals("Silver"))
					{
						typeOfCostumer.setNameType(NameType.Silver);
						typeOfCostumerDAO.setDiscount(typeOfCostumer);
						typeOfCostumerDAO.setRequestedPoints(typeOfCostumer);
					
					}
					
					
					users.add(new User(userID,username,password,firstName,lastName,gender,dateOfBirth,role,pointsCollected, typeOfCostumer));
				}
				
			}
		} catch (Exception ex) {
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
	
	public void loadArticals(String contextPath) {
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
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String articalID = st.nextToken().trim();
					String articalName = st.nextToken().trim();
				    Double price = Double.parseDouble(st.nextToken().trim());
					String typeString = st.nextToken().trim();
					Type type;
					if(typeString.equals("meal"))
					{
						type = Type.meal;
					} else{
						type = Type.drink;
					}
					
					String idRestaurant = st.nextToken().trim();
					RestourantDAO restaurantDAO = new RestourantDAO();
					Restaurant restaurant = restaurantDAO.findByID(idRestaurant);
					
					Double quantity = Double.parseDouble(st.nextToken().trim());
					String description = st.nextToken().trim();
					String articalImage = st.nextToken().trim();
			
					articals.add(new Artical(articalID, articalName, price, type, restaurant, quantity, description, articalImage));
				}
				
			}
		} catch (Exception ex) {
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
	
	private void loadCarts(String contextPath) {
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
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String cartID = st.nextToken().trim();
					double price = Double.parseDouble(st.nextToken().trim());
					
					String idCostumer = st.nextToken().trim();
					UserDAO costumerDAO = new UserDAO();
					User costumer = costumerDAO.findByID(idCostumer);
					
					String idCartItem = st.nextToken().trim();
					CartItemDAO cartItemDAO = new CartItemDAO();
					CartItem cartItem = cartItemDAO.findByID(idCartItem);
					
					carts.add(new Cart(cartID, price, costumer));
				}
				
			}
		} catch (Exception ex) {
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
	
	private void loadCartItem(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/cartsItem.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String cartItemID = st.nextToken().trim();
					
					String idBucket = st.nextToken().trim();
					CartDAO cartDAO = new CartDAO();
					Cart cart = cartDAO.findByID(idBucket);
					
					String idArtical = st.nextToken().trim();
					ArticalDAO articalDAO = new ArticalDAO();
					Artical artical = articalDAO.findByID(idArtical);

					String quantity = st.nextToken().trim();
					
					cartItems.add(new CartItem(cartItemID, cart, artical, quantity));
				}
				
			}
		} catch (Exception ex) {
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
	
	private void loadComments(String contextPath) {
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
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String commentID = st.nextToken().trim();
					String text = st.nextToken().trim();
					String gradeString = st.nextToken().trim();
					Grade grade;
					if(gradeString.equals("one"))
					{
						grade = Grade.one;
					} else if(gradeString.equals("two")){
						grade = Grade.two;
					} else if(gradeString.equals("three")) {
						grade = Grade.three;
					} else if(gradeString.equals("four")) {
						grade = Grade.four;
					} else {
						grade = Grade.five;
					}
				
					String idUser = st.nextToken().trim();
					UserDAO userDAO = new UserDAO();
					User user = userDAO.findByID(idUser);
					
					String idRestaurant = st.nextToken().trim();
					RestourantDAO restaurantDAO = new RestourantDAO();
					Restaurant restaurant = restaurantDAO.findByID(idRestaurant);
					String commentStatusString = st.nextToken().trim();
					
					CommentStatus commentStatus;
					if(commentStatusString.equals("Approved"))
					{
						commentStatus=CommentStatus.Approved;
					} else if(gradeString.equals("Not_approved")){
						commentStatus=CommentStatus.Not_approved;
					} else {
						commentStatus=CommentStatus.On_review;
					}
					
					comments.add(new Comment(commentID, text, grade, user, restaurant,commentStatus));
				}
				
			}
		} catch (Exception ex) {
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
	
	private void loadLocations(String contextPath) {
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
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String locationID = st.nextToken().trim();
					double geographicalLangth = Double.parseDouble(st.nextToken().trim());
					double geographicalWidth = Double.parseDouble(st.nextToken().trim());
					String adress = st.nextToken().trim();
					
					
					locations.add(new Location(locationID, geographicalLangth, geographicalWidth, adress));
				}
				
			}
		} catch (Exception ex) {
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
	
	private void loadOrders(String contextPath) {
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
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String orderID = st.nextToken().trim();
					java.util.Date orderDate = simpleDateFormat.parse(st.nextToken().trim());
					Double cost = Double.parseDouble(st.nextToken().trim());
					String orderStatusString = st.nextToken().trim();
					OrderStatus orderStatus;
					if(orderStatusString.equals("Transport")) 
					{
						orderStatus = OrderStatus.Transport;
					} else if(orderStatusString.equals("Processing"))
					{
						orderStatus = OrderStatus.Processing;
					} else if(orderStatusString.equals("PendingDelivery"))
					{
						orderStatus = OrderStatus.PendingDelivery;
					} else if(orderStatusString.equals("InPreparation"))
					{
						orderStatus = OrderStatus.InPreparation;
					} else if(orderStatusString.equals("Deliverd"))
					{
						orderStatus = OrderStatus.Deliverd;
					}else if(orderStatusString.equals("ManagerRequest"))
					{
						orderStatus = OrderStatus.ManagerRequest;
					}else
					{
						orderStatus = OrderStatus.Canceled;
					}
					
					String idCostumer = st.nextToken().trim();
					UserDAO costumerDAO = new UserDAO();
					User costumer = costumerDAO.findByID(idCostumer);
					
					String idDeliveryGuy = st.nextToken().trim();
					UserDAO deliveryGuyDAO = new UserDAO();
					User deliveryGuy = deliveryGuyDAO.findByID(idDeliveryGuy);
					
					
					String idRestaurant = st.nextToken().trim();
					RestourantDAO restaurantDAO = new RestourantDAO();
					Restaurant restaurant = restaurantDAO.findByID(idRestaurant);
					
					orders.add(new Order(orderID,orderDate ,cost, orderStatus, costumer, deliveryGuy,restaurant));
				}
				
			}
		} catch (Exception ex) {
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
	
	private void loadOrderItems(String contextPath) {
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
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String orderItemID = st.nextToken().trim();
				
					String idArtical = st.nextToken().trim();
					ArticalDAO articalDAO = new ArticalDAO();
					Artical artical = articalDAO.findByID(idArtical);
					
					String idRestaurant = st.nextToken().trim();
					RestourantDAO restaurantDAO = new RestourantDAO();
					Restaurant restaurant = restaurantDAO.findByID(idRestaurant);
					
					String idOrder = st.nextToken().trim();
					OrderDAO orderDAO = new OrderDAO();
					Order order = orderDAO.findById(idOrder);
					
					
					orderItems.add(new OrderItem(orderItemID, restaurant, artical,order));
				}
				
			}
		} catch (Exception ex) {
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
	
	private void loadRestaurants(String contextPath) {
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
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String restaurantID = st.nextToken().trim();
					String name = st.nextToken().trim();
					String restaurantType = st.nextToken().trim();
					String statusString = st.nextToken().trim();
					Status status;
					if(statusString.equals("working"))
					{
						status = Status.working;
					} else {
						status = Status.not_working;
					}
					
					String idManager = st.nextToken().trim();
					UserDAO userDAO = new UserDAO();
					User manager = userDAO.findByID(idManager);
					
					String idLocation = st.nextToken().trim();
					LocationDAO locationDAO = new LocationDAO();
					Location location = locationDAO.findByID(idLocation);

					String restaurantLogo = st.nextToken().trim();
					
					Double averageGrade = Double.parseDouble(st.nextToken().trim());
					
					restaurants.add(new Restaurant(restaurantID, name, restaurantType, status, manager, location, restaurantLogo, averageGrade));
				}
				
			}
		} catch (Exception ex) {
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
	
	private void loadTypeOfCostumers(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/typeOfCostumers.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					String typeOfCostumer = st.nextToken().trim();
					String nameTypeString = st.nextToken().trim();
					NameType nameType;
					if(nameTypeString.equals("Golden"))
					{
						nameType = NameType.Golden;
					} else if(nameTypeString.equals("Silver")) {
						nameType = NameType.Silver;
					}else {
						nameType = NameType.Bronze;
					}
					double discount = Double.parseDouble(st.nextToken().trim());	
					String requestedPoints = st.nextToken().trim();
					
					typeOfCostumers.add(new TypeOfCostumer(typeOfCostumer, nameType, discount, requestedPoints));
				}
				
			}
		} catch (Exception ex) {
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
	
	public void save() 
	{
		saveUser(contextPath);
		saveArtical(contextPath);
		saveCart(contextPath);
		saveCartItem(contextPath);
		saveComment(contextPath);
		saveLocation(contextPath);
		saveOrder(contextPath);
		saveOrderItem(contextPath);
		saveRestaurant(contextPath);
		saveTypeOfCostumer(contextPath);
	}
	
	public void saveUser(String contextPath) 
	{
		
		File file = new File(contextPath + "/users.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(User user : users) 
		{
			result += user.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			
		}
	}
	
	public void saveArtical(String contextPath) 
	{
		File file = new File(contextPath + "/articals.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(Artical artical : articals) 
		{
			result += artical.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveCart(String contextPath) 
	{
		File file = new File(contextPath + "/carts.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(Cart cart : carts) 
		{
			result += cart.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			
		}
	}
	
	public void saveCartItem(String contextPath) 
	{
		File file = new File(contextPath + "/cartsItem.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(CartItem cartItem : cartItems) 
		{
			result += cartItem.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			
		}
	}
	
	public void saveComment(String contextPath) 
	{
		File file = new File(contextPath + "/comments.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(Comment comment : comments) 
		{
			result += comment.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			
		}
	}
	
	public void saveLocation(String contextPath) 
	{
		File file = new File(contextPath + "/locations.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(Location location : locations) 
		{
			result += location.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			
		}
	}
	
	public void saveOrder(String contextPath) 
	{
		File file = new File(contextPath + "/orders.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(Order order : orders) 
		{
			result += order.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveOrderItem(String contextPath) 
	{
		File file = new File(contextPath + "/orderItems.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(OrderItem orderItem : orderItems) 
		{
			result += orderItem.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			
		}
	}
	
	public void saveRestaurant(String contextPath) 
	{
		File file = new File(contextPath + "/restaurants.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(Restaurant restaurant : restaurants) 
		{
			result += restaurant.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			
		}
	}
	
	public void saveTypeOfCostumer(String contextPath) 
	{
		File file = new File(contextPath + "/typeOfCostumers.txt");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			String result = "";
		
		
		for(TypeOfCostumer typeOfCostumer : typeOfCostumers) 
		{
			result += typeOfCostumer.ExportString() + "\n";
		}
		out.write(result);
		out.close();
	}
		catch(Exception e)
		{
			
		}
	}
	
}
