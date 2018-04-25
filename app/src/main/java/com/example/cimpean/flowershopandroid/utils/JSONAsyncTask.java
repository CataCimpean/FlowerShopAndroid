package com.example.cimpean.flowershopandroid.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cimpean.flowershopandroid.activity.order.OrderView;
import com.example.cimpean.flowershopandroid.model.Order;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Cimpean on 4/24/2018.
 */
public class JSONAsyncTask extends AsyncTask<String, Void, List<Order>> {

    private Context context;
    private OrderView orderView;
    private List<Order> listOfOrders;

    public JSONAsyncTask(Context context, OrderView orderView) {
        this.context = context;
        this.orderView = orderView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected List<Order> doInBackground(final String... flower) {

        listOfOrders = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, Constants.URL_MOCK_DATA_HTTPS, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            // Get the JSON array
                            JSONArray array = response.getJSONArray("orders");
                            if (array != null) {

                                // Loop through the array elements
                                for (int i = 0; i < array.length(); i++) {

                                    // Get current json object
                                    JSONObject order = array.getJSONObject(i);

                                    if (flower[0].equalsIgnoreCase(order.getString("flower_type"))) {

                                        // Get the current order (json object) data
                                        Integer id = Integer.valueOf(order.getString("id"));
                                        String deliver_to = order.getString("deliver_to");
                                        String flowerType = order.getString("flower_type");
                                        Date deliveryDate = Date.valueOf(order.getString("deliver_date"));
                                        String address = order.getString("address");
                                        Float price = Float.valueOf(order.getString("price"));

                                        Log.d("mockData=", id + " " + deliver_to + " " + flowerType + " " + deliveryDate + " " + address + " " + price);

                                        listOfOrders.add(new Order(id, deliver_to, flowerType, deliveryDate, address, price));

                                    }
                                }

                            }
                            orderView.setItems(listOfOrders);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialogUtil.showAlertDialogText("errorMessage", "Error display data.", context);
                    }
                });

        // Add JsonObjectRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);

        return listOfOrders;
    }


}