package com.example.fyt.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide; // 使用 Glide 库加载图片
import com.example.fyt.R;
import com.example.fyt.database.Project;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private final List<Project> projectList;
    private final OnProjectClickListener onProjectClickListener;

    public interface OnProjectClickListener {
        void onProjectClick(Project project);
    }

    public ProjectAdapter(List<Project> projectList, OnProjectClickListener listener) {
        this.projectList = projectList;
        this.onProjectClickListener = listener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.bind(project);
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {
        private final ImageView projectImage;
        private final TextView projectName;
        private final TextView projectDate;

        ProjectViewHolder(View itemView) {
            super(itemView);
            projectImage = itemView.findViewById(R.id.project_image);
            projectName = itemView.findViewById(R.id.project_name);
            projectDate = itemView.findViewById(R.id.project_date);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    onProjectClickListener.onProjectClick(projectList.get(position));
                }
            });
        }

        void bind(Project project) {
            projectName.setText(project.name);
            String dateString = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    .format(project.lastModified);
            projectDate.setText(dateString);

            if (project.imagePath != null) {
                Glide.with(projectImage.getContext())
                        .load(project.imagePath)
                        .into(projectImage);
            }
        }
    }
}