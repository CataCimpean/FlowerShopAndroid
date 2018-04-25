package com.example.cimpean.flowershopandroid.utils;


import android.content.Context;

import com.example.cimpean.flowershopandroid.model.Order;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cimpean on 4/23/2018.
 */

public class JSONParser {


    public static List<Order> orderItemsList = null;
    public static String urlMockData = "https://demo0566295.mockable.io/flowerShop";


    public static List<Order> getMockData(final Context mContext, final String flowerName) {
        return Arrays.asList(new Order(1,"Catalin","floare1", Date.valueOf("2000-11-01"),"Cluj",Float.valueOf("231")));
    }



   /* public static List<Order> getMockData(final Context mContext, final String flowerName) {


        Log.d("contextHere=",mContext.toString());
        Log.d("flowerHere=",flowerName);

        // Initialize a new RequestQueue instance
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        // Initialize a new JsonObjectRequest instance
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlMockData,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Do something with response
                        //mTextView.setText(response.toString());
                        Log.d("response","sunt in response");
                        // Process the JSON
                        try {
                            // Get the JSON array
                            JSONArray array = response.getJSONArray("orders");
                            if (array != null) {
                                orderItemsList = new ArrayList<>();

                                // Loop through the array elements
                                for (int i = 0; i < array.length(); i++) {
                                    // Get current json object


                                    JSONObject order = array.getJSONObject(i);

                                    Log.d("jsonOutside","sunt outside");
                                    if (flowerName.equalsIgnoreCase(order.getString("flower_type"))) {
                                        Log.d("jsonInside","sunt inside");
                                        // Get the current order (json object) data
                                        Integer id = Integer.valueOf(order.getString("id"));
                                        String deliver_to = order.getString("deliver_to");
                                        String flowerType = order.getString("flower_type");
                                        Date deliveryDate = Date.valueOf(order.getString("deliver_date"));
                                        String address = order.getString("address");
                                        Float price = Float.valueOf(order.getString("price"));

                                        Log.d("mockData=", id + " " + deliver_to + " " + flowerType + " " + deliveryDate + " " + address + " " + price);

                                        orderItemsList.add(new Order(id, deliver_to, flowerType, deliveryDate, address, price));
                                    }
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialogUtil.showAlertDialogText("Error read mock data", error.getMessage(), mContext);
                    }
                }
        );

        // Add JsonObjectRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);


        return orderItemsList;
    }
*/


}

