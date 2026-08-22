package api.core.streamx.modules.analytics.ui;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class MetricCard extends VerticalLayout {

    public MetricCard(String title, String value, String percentageText, boolean isPositive) {
        setClassName(LumoUtility.Background.BASE);
        getStyle().set("border", "1px solid var(--lumo-contrast-10pct)");
        getStyle().set("border-radius", "var(--lumo-border-radius-m)");
        getStyle().set("padding", "var(--lumo-space-m)");
        setWidthFull();

        H3 titleLabel = new H3(title);
        titleLabel.setClassName(LumoUtility.TextColor.SECONDARY);
        titleLabel.getStyle().set("font-size", "var(--lumo-font-size-s)");
        //titleLabel.setMargin(false);

        Span valueLabel = new Span(value);
        valueLabel.setClassName(LumoUtility.FontSize.XXXLARGE);
        valueLabel.setClassName(LumoUtility.FontWeight.BOLD);

        Span pctLabel = new Span(percentageText);
        pctLabel.getStyle().setColor(isPositive ? "var(--lumo-success-color)" : "var(--lumo-error-color)");
        pctLabel.setClassName(LumoUtility.FontWeight.SEMIBOLD);

        ProgressBar progressBar = new ProgressBar();
        double pctValue = 0.0;
        if (percentageText != null) {
            java.util.regex.Matcher m = java.util.regex.Pattern.compile("([+-]?\\d+[\\.,]?\\d*)").matcher(percentageText);
            if (m.find()) {
                try {
                    pctValue = Double.parseDouble(m.group(1).replace(",", "."));
                } catch (NumberFormatException e) {
                    pctValue = 0.0;
                }
            }
        }
        progressBar.setValue(Math.min(Math.abs(pctValue) / 100.0, 1.0));
        progressBar.setWidthFull();

        add(titleLabel, valueLabel, pctLabel, progressBar);
    }
}
