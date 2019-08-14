(ns demo.events.core
  (:require [re-frame.core :as re-frame]
            [ajax.core :as ajax]
            [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re-frame/reg-event-db
 :initialize-db
 (fn-traced  [_ _]
             {:page :home}))

(re-frame/reg-event-db
 :routes/home
 (fn-traced  [db _]
             (-> db
                 (assoc :page :home))))

(re-frame/reg-event-db
 :routes/about
 (fn-traced  [db _]
             (-> db
                 (assoc :page :about))))

(re-frame/reg-event-db
 :routes/work
 (fn-traced  [db _]
             (-> db
                 (assoc :page :work))))

(re-frame/reg-event-fx
 :handler-with-http
 (fn [{:keys [db]} [_ source]]
   {:db (assoc db :show-twirly true)
    :http-xhrio {:method :get
                 :uri source
                 :timeout 8000
                 :response-format (ajax/raw-response-format {:keywords? true})
                 :on-success [:good-http-result]
                 :on-failure [:bad-http-result]}}))

(re-frame/reg-event-db
 :good-http-result
 (fn [db [_ result]]
   (assoc db :success-http-result result
             :show-twirly false)))

(re-frame/reg-event-db
 :bad-http-result
 (fn [db [_ result]]
    ;; result is a map containing details of the failure
   (assoc db :failure-http-result result
             :show-twirly false)))